A=[2,3,1;4,1,-2;-2,1,2];
B=[9;2;-3];

x=A\B;
disp("Solution using inbuilt function is: ",x);

C=[A B];//augmented matrix
disp("Augmented Matrix",C);

[n m]=size(C);

for i = 1:n
    C(i, :) = C(i, :) / C(i, i);
    
    for j = 1:n
        if i ~= j
            fact = C(j, i);
            C(j, :) = C(j, :) - fact * C(i, :);
        end
    end
end
disp("Augmented Matrix after Forward Elimination",C);

X = C(:, n+1);

disp("Solution X:");
disp(X);
