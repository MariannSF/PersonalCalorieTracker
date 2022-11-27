import java.io.File

class User(var uname : String) {
    var username = uname;

    var password = "";
    var name = "";
    var userHeight = 0.0;
    var userWeight = 0.0;
    var userTotalBurnedCals = 0;
    var userTotalConsumedCals = 0;

    fun saveToFile() {      //Save object to txt file
        val dir = File("userdata/");
        var file = File("userdata/$username.txt");
        if (!dir.isDirectory)
            dir.mkdir();

        file.writeText(
          "$username\n" +
                  "$password\n" +
                  "$name\n" +
                  "$userHeight\n" +
                  "$userWeight\n" +
                  "$userTotalBurnedCals\n" +
                  "$userTotalConsumedCals"
        );
    }

    fun loadFile(): Boolean {       //Load user data to object
        val dir = File("userdata/");
        var file = File("userdata/$username.txt");
        if (!dir.isDirectory)
            dir.mkdir();

        if(!file.isFile())
            return false;

        var userData = file.readLines();
        this.password = userData[1];
        this.name = userData[2];
        this.userHeight = userData[3].toDouble();
        this.userWeight = userData[4].toDouble();
        this.userTotalBurnedCals = userData[5].toInt();
        this.userTotalConsumedCals = userData[6].toInt();

        return true;
    }
}