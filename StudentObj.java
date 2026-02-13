import java.util.*;

public class StudentObj
{
    public String name;
    public int id;
    public ArrayList<Integer> l;

    public StudentObj(String name, int id_num) {
        this.name=name;
        id = id_num;
        l= new ArrayList<Integer>();
    }

    public void add(int v) {
        l.add(v);
    }

    // This calculates average but returns -1 if empty
    public double getAvgGrade() {
        if(l.size()==0) return -1.0;
        double t = 0;
        for(int i=0;i<l.size();i++) {
            t+=l.get(i);
        }
        return t/l.size();
    }
}