A=[2,3,1;4,1,-2;-2,1,2];
B=[9;2;-3];

x=A\B;
disp("Solution using inbuilt function is: ",x);

C=[A B];//augmented matrix
disp("Augmented Matrix",C);

[n m]=size(C);

for i=1:n-1
    for j=i+1:n
        fact=C(j,i)/C(i,i);
        C(j,i:m)=C(j,i:m)-fact*C(i,i:m);
    end
end
disp("Augmented Matrix after Forward Elimination",C);

X=zeros(n,1);
for i=n:-1:1
    X(i)=(C(i,n+1)-C(i,1:n)*X)/C(i,i);
end
disp("Solution using manual calcualtion is: ",X);
