/*
Given an array of strings (all lowercase letters), the task is to group them in such a way that all strings in a group are shifted versions of each other. Two string S and T are called shifted if,

S.length = T.length
and
S[i] = T[i] + K for
1 <= i <= S.length  for a constant integer K
For example strings {acd, dfg, wyz, yab, mop} are shifted versions of each other.

Input  : str[] = {"acd", "dfg", "wyz", "yab", "mop",
                 "bdfh", "a", "x", "moqs"};

Output : a x
         acd dfg wyz yab mop
         bdfh moqs
All shifted strings are grouped together.
*/
public class GroupShiftedStrings {

}
