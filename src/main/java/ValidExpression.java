/*
Given a string of parentheses, write a function to compute the minimum number of parentheses to be removed to make the string valid (i.e. each open parenthesis is eventually closed).

For example, given the string "()())()", you should return 1. Given the string ")(", you should return 2, since we must remove all of them
 )(

()

()())()

push
pop
push
pop

peek , c++

push
pop

c + len(stack) (0)


()))()))((

( push
) peek, pop
) peek c++
) peek, c++
( push
) peek, pop

) peek, c++
) peek, c++

( push
( push

c + len(stack)



0

)(

) peek, c++
( push

c + 1

()))()))((

( len++
) len>0, len--
) len>0, counter++
) len>0, counter++
( len++
) len > 0, len--
) len >0, counter++
) len >0, counter++
( len++
( len++

counter + len










 */
public class ValidExpression {

    public static void main(String[] args) {
        String exp = "()())()";
        int count = 0;
        int flag = 0;
        for (int i = 0; i < exp.length(); i++){
            if(exp.charAt(i) == '('){
                flag++;
            }
            else if(exp.charAt(i) == ')'){
                flag--;
            }

        }



    }
}
