#Zachary Job
#10.29.11
#V 1

#makeFile.mak

NAME = graphA5
TARBALL = Zachary Job-$(NAME).tar.gz
SRC = myGraph.h myGraph.cpp main.h main.cpp
OBJ = $(SRC:.cpp=.o)
RM = rm -f

#Compile
all: $(OBJ)
	g++ $(OBJ) -o $(NAME)

#Clean
clean:
	-$(RM) *~
	-$(RM) \#*
	-$(RM) *.o
	-$(RM) *.core

fclean:	clean
	-$(RM) $(NAME)

re: fclean all

submit: fclean
	tar cvzf $(TARBALL) *

