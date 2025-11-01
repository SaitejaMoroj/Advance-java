package MyJdbc.Mypackage;

public class Main {

    public static void main(String[] args) {
        //DriverLoading
        //Connection Establishment
        //Statement Execute
        //ExecuteQuery

Setup st=new Setup();
st.createDatabase();
//st.createTable();
//CURD OPERATION
st.createData();


    }
}
