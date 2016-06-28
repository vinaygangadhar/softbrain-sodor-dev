# Declaration of common variables

RISCV           := /usr/local
srcDir          := /Users/vinaygangadhar/IdeaProjects/riscv-sodor-dev
installTop      := $(DESTDIR)$(RISCV)
buildIncludeDir := $(RISCV)/include
buildLibDir     := $(RISCV)/lib
buildDir        := /Users/vinaygangadhar/IdeaProjects/riscv-sodor-dev

# Paths to different source trees
chiseldir       := 

CXX := g++
SBT := java -Xmx4096M -Xss8M -XX:MaxPermSize=128M -jar $(srcDir)/sbt/sbt-launch.jar $(SBT_FLAGS)

