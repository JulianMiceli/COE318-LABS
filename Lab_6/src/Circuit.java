import java.util.ArrayList;

public class Circuit 
{
    private ArrayList<Resistor> Resistors = new ArrayList<Resistor>();
    private static Circuit Instance = null;
    
        public static Circuit getInstance() 
        {
            if (Instance == null)
            {
                Instance = new Circuit();
            }
            return Instance;
        }

        private Circuit()
        {
            
        }
    
        void add(Resistor r)
        {
            Resistors.add(r);
        }
    
        @Override
        public String toString()
        {
            String Resistor_Values = "";
            for(Resistor resistor : this.Resistors)
            {
                Resistor_Values += resistor.toString()+"\n";
            }
            return Resistor_Values;
        }
}