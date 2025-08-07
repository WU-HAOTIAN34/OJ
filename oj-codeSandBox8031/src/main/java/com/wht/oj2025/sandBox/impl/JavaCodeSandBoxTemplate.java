package com.wht.oj2025.sandBox.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import com.wht.oj2025.constant.FileConstant;
import com.wht.oj2025.dto.CodeSandBoxDTO;
import com.wht.oj2025.enumeration.QuestionStatus;
import com.wht.oj2025.exception.BaseException;
import com.wht.oj2025.result.CodeSandBoxResult;
import com.wht.oj2025.result.ExecuteResult;
import com.wht.oj2025.result.JudgeResult;
import com.wht.oj2025.sandBox.CodeSandBox;
import com.wht.oj2025.util.ProcessUtil;
import org.apache.logging.log4j.util.ProcessIdUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class JavaCodeSandBoxTemplate implements CodeSandBox {



    public File save(String code){
        String property = System.getProperty("user.dir");
        String parentFolder = property + File.separator + "code";

        if (!FileUtil.exist(parentFolder)) {
            FileUtil.mkdir(parentFolder);
        }

        String javaPath = parentFolder + File.separator + "java";

        if (!FileUtil.exist(javaPath)) {
            FileUtil.mkdir(javaPath);
        }

        String codePath = javaPath + File.separator + UUID.randomUUID();
        String codeName = codePath + File.separator + "Main.java";

        return FileUtil.writeString(code, codeName, "UTF-8");
    }


    public ExecuteResult compile(File code){
        String cmd = String.format("javac -encoding utf-8 %s", code.getAbsolutePath());
        try {
            Process exec = Runtime.getRuntime().exec(cmd);
            ExecuteResult res = ProcessUtil.runProcessAndGetMessage(exec, "编译");
            if (res.getExitCode() != 0){
                throw new BaseException(FileConstant.COMPILE_ERROR);
            }
            return res;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public List<ExecuteResult> run(List<String> inputs, File code, Long time){
        File absoluteFile = code.getParentFile().getAbsoluteFile();
        List<ExecuteResult> results = new ArrayList<>();

        for (String s:inputs){
            String cmd = String.format("java -Xmx256m -Dfile.encoding=UTF-8 -cp %s Main %s", absoluteFile, s);

            try {
                Process runProcess = Runtime.getRuntime().exec(cmd);

                new Thread(() -> {
                    try {
                        Thread.sleep(time);
                        runProcess.destroy();

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }).start();
                ExecuteResult res = ProcessUtil.runProcessAndGetMessage(runProcess, "运行");
                results.add(res);
                // System.out.println(res);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return results;

    }


    public CodeSandBoxResult getResult(List<ExecuteResult> runRes, ExecuteResult compRes){
        CodeSandBoxResult res = new CodeSandBoxResult();

        if (compRes.getExitCode() != 0){
            res.setRes(new ArrayList<>());
            res.setStatus(QuestionStatus.FAILED.getCode());
            res.setJudgeResult(new JudgeResult().setMsg(compRes.getErrorMsg()));
            res.setMsg(compRes.getErrorMsg());
        }

        Long maxTime = 0L;
        List<String> outputs = new ArrayList<>();
        for (ExecuteResult r:runRes){
            if (r.getExitCode() != 0){
                res.setRes(outputs);
                res.setStatus(QuestionStatus.FAILED.getCode());
                res.setMsg(r.getErrorMsg());
                res.setJudgeResult(new JudgeResult().setMsg(r.getErrorMsg()).setTime(maxTime));
                return res;
            }
            maxTime = Math.max(maxTime, r.getTime());
            outputs.add(r.getMsg());
        }
        res.setRes(outputs);
        res.setStatus(QuestionStatus.SUCCEED.getCode());
        res.setJudgeResult(new JudgeResult().setTime(maxTime));
        return res;
    }

    public void deleteFolder(File dir){
        if (dir.getParentFile() != null){
            FileUtil.del(dir.getParentFile().getAbsoluteFile());
        }
    }



    public CodeSandBoxResult execute(CodeSandBoxDTO codeSandBoxDTO){
        File save = save(codeSandBoxDTO.getCode());
        ExecuteResult compile = compile(save);
        List<ExecuteResult> run = run(codeSandBoxDTO.getCases(), save, codeSandBoxDTO.getTime());
        CodeSandBoxResult res = getResult(run, compile);
        deleteFolder(save);
        return res;
    }

}
