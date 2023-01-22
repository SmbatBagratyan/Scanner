$(eval TMP := $(shell mktemp))
C = "cc"
COMPILER = "compiler0"
INP0 = "input0.txt"
OUT0 = "./output0.txt"
TMP0 = "/tmp/output0.txt"
DIFF = "/usr/bin/diff"
CMD = "/usr/bin/diff /tmp/output0.txt ./output0.txt"
all:
			javac -classpath src src/ReadFile.java
			javac -classpath src src/Scanner.java
			javac -classpath src src/Main.java
			cp src/*.class .
test:
			java Main $(INP0) > $(TMP0)
ifeq ("$(shell $(DIFF) $(TMP0) $(OUT0) ; echo $$?)", "0")
			@echo "(:"
else
			@echo ":/"
endif
