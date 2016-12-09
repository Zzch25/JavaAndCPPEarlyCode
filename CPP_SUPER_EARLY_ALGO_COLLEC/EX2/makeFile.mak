#Zachary Job
#10.8.11
#V 1

#makeFile.mak

NAME = sortA4
TARBALL = Zachary Job-$(NAME).tar.gz
SRC = Sortings.h Sortings.cpp main.cpp
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

