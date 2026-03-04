# test.py
import sys

print("Python脚本开始执行")
print(f"接收到的参数: {sys.argv}")
print(f"参数数量: {len(sys.argv)}")

if len(sys.argv) > 1:
    for i, arg in enumerate(sys.argv[1:], 1):
        print(f"参数{i}: {arg}")

# 执行一些计算
result = sum(range(1, 11))
print(f"1到10的和是: {result}")

print("脚本执行完成")