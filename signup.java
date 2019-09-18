/*File file = new File("/home/ayam/DSA_Project/Files/"+username+"");	
			
				if(!file.exists())		//checks whether the file with the same username exists or not
				{
					FileWriter fw = new FileWriter(file);	//if doesn't exist then it will create a file 
					BufferedWriter bw = new BufferedWriter(fw);	//and store the basic info in that file
				
					fw.write(fname+","+username+","+email+","+passwd+","+contact+","+dob+",-");
					bw.close();		//closes the file

					readMatrix();

					setVisible(false);	//as signup is successful, it will dispose the window

					postlogin pl = new postlogin(email);	//calling the constructor of postlogin class 
					pl.main();				//and its main function
				}
			
				else				//if file exists then it will show that user exists and will tell to change the username
				{
					l7.setText("This user exists! Please use different username!");
				}*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;


class signup
{
    
    private String fname, lname, username, email, passwd;

    public signup(String fname, String lname, String username, String email, String passwd)
    {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.email = email;
        this.passwd = passwd;
    }

    public String getUsername() {
		return username;
	}

	public boolean createAcc()
    {
        boolean status = false;
        try
        {
            //File file = new File("/Files/"+this.username+"");
            File file = new File(this.username);	
			
            if(!file.exists())		//checks whether the file with the same username exists or not
            {
                FileWriter fw = new FileWriter(file);	//if doesn't exist then it will create a file 
                BufferedWriter bw = new BufferedWriter(fw);	//and store the basic info in that file
            
                fw.write(this.fname + "," + this.lname + "," + this.username + "," + this.email + "," + this.passwd);
                bw.close();		//closes the file
                status = true;
            }
        
            else				//if file exists then it will show that user exists and will tell to change the username
            {
                System.out.println("This user exists! Please use different username!");
                status = false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return status;
    }
    
    public boolean isUsernameUnique (String s) {
    	File f = new File(s);
    	
    	if (f.exists())
    		return false;
    	else 
    		return true;
    }

	public boolean checkCredLength(String pwd) {
		if (pwd.length() >= 8)
			return true;
		// TODO Auto-generated method stub
		return false;
	}

}