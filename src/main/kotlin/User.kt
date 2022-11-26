import java.io.File

class User(var uname : String) {
    var username = uname;

    var password = "";
    var name = "";
    var userHeight = 0;
    var userWeight = 0;
    var userBMI = 0.0;
    var userTotalBurnedCals = 0;
    var userTotalConsumedCals = 0;

    fun saveToFile() {
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
                  "$userBMI\n" +
                  "$userTotalBurnedCals\n" +
                  "$userTotalConsumedCals"
        );
    }

    fun loadFile(): Boolean {
        val dir = File("userdata/");
        var file = File("userdata/$username.txt");
        if (!dir.isDirectory)
            dir.mkdir();

        if(!file.isFile())
            return false;

        var userData = file.readLines();
        this.password = userData[1];
        this.name = userData[2];
        this.userHeight = userData[3].toInt();
        this.userWeight = userData[4].toInt();
        this.userBMI = userData[5].toDouble();
        this.userTotalBurnedCals = userData[6].toInt();
        this.userTotalConsumedCals = userData[7].toInt();

        return true;
    }
}