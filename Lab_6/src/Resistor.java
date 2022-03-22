public class Resistor 
{
    double Resistance = 0.0;
    int ID_Number = 0;
    static int ID_Next = 0;
    Node NodeA;
    Node NodeB;
    
        public Resistor(double resistance, Node node1, Node node2)
        {
            this.Resistance = resistance;
            this.NodeA = node1;
            this.NodeB = node2;
            this.ID_Number = ID_Next;
            ID_Next++;
            Circuit cir = Circuit.getInstance();
            cir.add(this);
        }
        
        public Node[] getNodes()
        {
            Node[] Node = {this.NodeA, this.NodeB};
            return Node;
        }
        
        @Override
        public String toString()
        {
            return " " + this.ID_Number + " " + this.getNodes()[0].toString() +
                    " " + this.getNodes()[1].toString() + " " + this.Resistance;
        }
}