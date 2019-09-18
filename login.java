import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


class login
{
    
    private String username, passwd;

    public login(String username, String passwd)
    {
        this.username = username;
        this.passwd = passwd;
    }

    public boolean loginAcc()
    {
        boolean status = false;
        try
        {
            File file = new File(this.username);
            BufferedReader br = null;		
			br = new BufferedReader(new FileReader(file));	
			
            if(file.exists())		//checks whether the file with the same username exists or not
            {
                StringBuilder sb = new StringBuilder();	//if exists then reads the file 
				String line = br.readLine();		//and stores the data of the file in a string
                String[] string1 = line.split(",");	//then the string is splitted by "," and stored in a string array
                
                if(passwd.equals(string1[4]))		//if the passwd textfield and the data at the 4th index of the string array matches
				{
                    System.out.println("Welcome " + string1[0]);
                    status = true;
				}
				else if(!passwd.equals(string1[4]))		//if not then prints the below statement
				{
                    System.out.println("Incorrect email-id or password");
                    status = false;
				}
            }
            else				//if file exists then it will show that user exists and will tell to change the username
            {
                System.out.println("Either you don't have an account or username is wrong");
            }  
            br.close();
        }
        catch(Exception e)
        {
            System.out.println("Either you don't have an account or username is wrong");
        }
        
        return status;
    }

}