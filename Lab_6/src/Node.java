public class Node 
{
    int Ident_Number = 0;
    static int Next_Ident_Number = 0;
    
        public Node()
        {
            this.Ident_Number = Next_Ident_Number;
            Next_Ident_Number++;
        }
        
        @Override
        public String toString()
        {
            return "" + this.Ident_Number;
        }
}