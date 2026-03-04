import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PythonExecutor {

    public static void main(String[] args) {
        // Python解释器路径（如果已添加到系统PATH，可以直接使用"python"）
        String pythonInterpreter = "python.exe";
        // 要执行的Python文件路径
        String pythonScript = "src/test.py";
        // 传递给Python脚本的参数（可选）
        String[] scriptArgs = {"arg1", "arg2", "arg3"};

        try {
            // 构建命令
            String[] command = buildCommand(pythonInterpreter, pythonScript, scriptArgs);

            // 方法1: 使用ProcessBuilder（推荐）
            executeWithProcessBuilder(command);

            // 或方法2: 使用Runtime.getRuntime().exec()
            // executeWithRuntime(command);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 构建执行命令
     */
    private static String[] buildCommand(String interpreter, String script, String[] args) {
        // 命令格式: python.exe script.py arg1 arg2 arg3
        String[] command = new String[2 + (args != null ? args.length : 0)];
        command[0] = interpreter;
        command[1] = script;

        if (args != null) {
            System.arraycopy(args, 0, command, 2, args.length);
        }

        return command;
    }

    /**
     * 使用ProcessBuilder执行命令（推荐）
     */
    private static void executeWithProcessBuilder(String[] command) throws IOException, InterruptedException {
        System.out.println("执行命令: " + String.join(" ", command));

        // 创建ProcessBuilder
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.redirectErrorStream(true); // 合并标准错误和标准输出

        // 启动进程
        Process process = pb.start();

        // 读取输出
        printProcessOutput(process.getInputStream());

        // 等待进程完成
        int exitCode = process.waitFor();
        System.out.println("Python脚本执行完成，退出码: " + exitCode);
    }

    /**
     * 使用Runtime.exec()执行命令
     */
    private static void executeWithRuntime(String[] command) throws IOException, InterruptedException {
        System.out.println("执行命令: " + String.join(" ", command));

        // 启动进程
        Process process = Runtime.getRuntime().exec(command);

        // 读取标准输出
        printProcessOutput(process.getInputStream());

        // 读取错误输出
        printProcessOutput(process.getErrorStream());

        // 等待进程完成
        int exitCode = process.waitFor();
        System.out.println("Python脚本执行完成，退出码: " + exitCode);
    }

    /**
     * 读取并打印进程输出
     */
    private static void printProcessOutput(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "GBK"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    /**
     * 执行Python脚本并传递输入参数
     */
    public static void executePythonWithInput() {
        String pythonCode =
                "import sys\n" +
                        "print('Python版本:', sys.version)\n" +
                        "print('参数列表:', sys.argv)\n" +
                        "if len(sys.argv) > 1:\n" +
                        "    for i, arg in enumerate(sys.argv[1:]):\n" +
                        "        print(f'参数{i+1}: {arg}')\n" +
                        "# 模拟处理过程\n" +
                        "result = 0\n" +
                        "for i in range(1, 6):\n" +
                        "    result += i\n" +
                        "print(f'1到5的和是: {result}')";

        try {
            // 将Python代码保存到临时文件
            String tempScript = "temp_script.py";
            java.nio.file.Files.write(
                    java.nio.file.Paths.get(tempScript),
                    pythonCode.getBytes()
            );

            // 执行临时脚本
            ProcessBuilder pb = new ProcessBuilder("python.exe", tempScript, "参数1", "参数2", "参数3");
            pb.redirectErrorStream(true);
            Process process = pb.start();

            // 实时输出
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), "GBK"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Python输出: " + line);
                }
            }

            int exitCode = process.waitFor();
            System.out.println("退出码: " + exitCode);

            // 删除临时文件
            new java.io.File(tempScript).delete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}