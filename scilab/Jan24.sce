A = [1,2;3,4;]
B = [5,6;7,8;]
C = [9,0;1,2;]

disp("Matrix A:",A);
disp("Matrix B:",B);
disp("Matrix C:",C);

leftSide = A * (B + C);
rightSide = (A * B) + (A * C);

disp("Left Side A * (B + C):");
disp(leftSide);

disp("Right Side (A * B) + (A * C):");
disp(rightSide);
