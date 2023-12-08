package com.example.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quiz.mcurr as mcurr
private var user:String?=null;
private var progres:ProgressBar?=null
private var tvprog:TextView?=null
private var image:ImageView?=null
private var tvq:TextView?=null
private var op1:TextView?=null
private var op2:TextView?=null
private var op3:TextView?=null
private var op4:TextView?=null
private var mcurr:Int=0
private var mquestion:ArrayList<questions>?=null
private var mselectedop:Int=0
private var sub:Button?=null
private var cor:Int=0

class questions_main : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        mquestion = constant.getq();
        user=intent.getStringExtra(constant.Usename)
        setQ(mquestion)



    }

    private fun setQ(mquestion: ArrayList<questions>?) {


defaultoption();
        progres = findViewById(R.id.progress);
        tvprog = findViewById(R.id.qi);
        image = findViewById(R.id.img);
        tvq = findViewById(R.id.ques);
        op1 = findViewById(R.id.fir);
        op2 = findViewById(R.id.sec)
        op3 = findViewById(R.id.thir)
        op4 = findViewById(R.id.forth)
sub=findViewById(R.id.submit)
op1?.setOnClickListener(this)
        op2?.setOnClickListener(this)
        op3?.setOnClickListener(this)
        op4?.setOnClickListener(this)
        sub?.setOnClickListener(this)
        var Question: questions = mquestion!![mcurr];
        progres?.progress = mcurr + 1;
        tvprog?.setText("${mcurr + 1}/${progres?.max}")
        image?.setImageResource(Question.img)
        tvq?.setText(Question.question)


        op1?.setText(Question.op1)
        op2?.setText(Question.op2)
        op3?.setText(Question.op3)
        op4?.setText(Question.op4)
        if(mcurr+1==mquestion!!.size){
            sub?.setText("Finish")

        }
defaultoption();



    }
private fun defaultoption(){
    var options=ArrayList<TextView>();
op1?.let{
    options.add(0,it)
}
    op2?.let{
        options.add(1,it)
    }
    op3?.let{
        options.add(2,it)
    }
    op4?.let{
        options.add(2,it)
    }

for(option in options){
    option.setTextColor(Color.parseColor("#E234E6"))
    option.typeface= Typeface.DEFAULT
    option.background=ContextCompat.getDrawable(
this,R.drawable.just_for_sake

    )
}

}
    fun selectedopview(tv:TextView,selectednum:Int){
        defaultoption();
        mselectedop=selectednum
tv.setTextColor(Color.parseColor("#363AFF"))
    tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,R.drawable.outlined
        )
    }
    override fun onClick(view: View) {

        when(view?.id){
            R.id.fir->{
                op1?.let {
                    selectedopview(it,1)
                }
            }
            R.id.sec->{
                op2?.let {
                    selectedopview(it,2)
                }
            }
            R.id.thir->{
                op3?.let {
                    selectedopview(it,3)
                }
            }
            R.id.forth->{
                op4?.let {
                    selectedopview(it,4)
                }
            }
       R.id.submit->{
           if(mselectedop==0){
               mcurr++;
               when{


                   (mcurr<= mquestion!!.size-1)-> {
                   setQ(mquestion)
               }
                   else->{
                       val intent2=Intent(this,result_activity::class.java)
                      intent2.putExtra(constant.correct2, cor.toString())

                       intent2.putExtra(constant.Usename, user)
                      intent2.putExtra(constant.total, mquestion!!.size.toString())
                      startActivity(intent2)
                              finish()
                   }
           }

           }
           else{
               var q= mquestion?.get(mcurr)
               if(q!!.correct== mselectedop){
                   cor+=1
                   answerview(mselectedop,R.drawable.correct_option_bg)

               }
               else{

                       answerview(mselectedop,R.drawable.wroung_option_bg)


               }
               if(mcurr== mquestion!!.size){
                   sub?.text="Finish"


               }
               else{
                   sub?.text="Next"
               }
           }
mselectedop=0;
       }
        }
    }
    fun answerview(answer:Int,Drawable:Int){
        when(answer){
            1->{
                op1?.background=ContextCompat.getDrawable(
                    this,
                    Drawable
                )
            }
            2->{
                op2?.background=ContextCompat.getDrawable(
                    this,
                    Drawable
                )
            }
            3->{
                op3?.background=ContextCompat.getDrawable(
                    this,
                    Drawable
                )
            }
            4->{
                op4?.background=ContextCompat.getDrawable(
                    this,
                    Drawable
                )
            }



        }
    }

}