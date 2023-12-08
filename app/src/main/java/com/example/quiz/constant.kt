package com.example.quiz

object constant {
     var Usename:String?=null;
    var correct2:String?=null;
      var total:String?=null;
    fun getq():ArrayList<questions>{
val retq=ArrayList<questions>();
    val q1=questions(
1,"what Tv show is this ?",R.drawable.q1,
        "breaking bad","howard","Rick and Morty","chotta bheem",
        3

    )
retq.add(q1);
    val q2=questions(
        2,"which country's flag is this ?",R.drawable.saudi,
        "Saudi","Brazil","Qatar","Pakistan",
        1

    )
    retq.add(q2);
    val q3=questions(
        3,"what biggest disaster is thin in this image ?",R.drawable.chernobyl,
        "Bhopal gas tragedy","chernobyl Nuclear disaster ","WW2","Pakistan",
        2

    )
    retq.add(q3);
    val q4=questions(
        4,"who's wife is this lady ?",R.drawable.georgina,
        "Cristiano","Messi","Modiji","lalu Yadav",
        1

    )
    retq.add(q4);

return retq
}



}