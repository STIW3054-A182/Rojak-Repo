package com.Stiw3054.groupProject;
import java.util.ArrayList;
import java.util.List;
public class ObjectTable  {
    private List <String>arrayRK = new ArrayList<String>();
    private List <String>arraySno=new ArrayList<String>();
    private List <String>arrayName=new ArrayList<String>();
    private  List <String>arrayRtg=new ArrayList<String>();
    private List <String>arrayState=new ArrayList<String>();
    private  List <String>arrayPts=new ArrayList<String>();
    private List <String>arrayCat =new ArrayList<String>();
    private int count ;
    public ObjectTable() {

    }

    public List<String> getArrayRK() {
        return arrayRK;
    }

    public List<String> getArraySno() {
        return arraySno;
    }

    public List<String> getArrayName() {
        return arrayName;
    }

    public List<String> getArrayRtg() {
        return arrayRtg;
    }

    public List<String> getArrayState() {
        return arrayState;
    }

    public List<String> getArrayPts() {
        return arrayPts;
    }

    public List<String> getArrayCat() {
        return arrayCat;
    }

    public void setArrayRK(String RK) { arrayRK.add(RK) ; }

    public void setArraySno(String Sno) {
        arraySno.add(Sno) ;
    }

    public void setArrayName(String Name) {
        arrayName.add(Name) ;
    }

    public void setArrayRtg(String Rtg) { arrayRtg.add(Rtg) ; }

    public void setArrayState(String State) { arrayState.add( State) ; }

    public void setArrayPts(String Pts) { arrayPts.add(Pts) ; }

    public void setArrayCat(String Cat) { arrayCat.add(Cat);}
}
