import os
abspath = os.path.abspath(__file__)
dname = os.path.dirname(abspath)
os.chdir(dname)
os.system("gnugo.exe -l moves.sgf -t -L 3 2> moves.txt");
