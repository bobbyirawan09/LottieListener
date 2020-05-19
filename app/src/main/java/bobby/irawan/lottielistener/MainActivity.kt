package bobby.irawan.lottielistener

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lottie_animation_view.setAnimationFromUrl("https://assets7.lottiefiles.com/private_files/lf30_yP8raD.json")
        lottie_animation_view.addAnimatorUpdateListener {
            val progress = (it.animatedValue as Float * 100).toInt()
            text_view_progress.text = progress.toString() + "%"
            if (progress >= 50 && progress != 0) {
                lottie_animation_view.pauseAnimation()
                text_view_information.text = "Already hit 50%"
            } else {
                text_view_information.text = ""
            }
        }

        button_cancel.setOnClickListener {
            lottie_animation_view.cancelAnimation()
        }

        lottie_animation_view.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                //Do nothing
            }

            override fun onAnimationEnd(animation: Animator?) {
                //Do nothing
            }

            override fun onAnimationCancel(animation: Animator?) {
                lottie_animation_view.visibility = View.GONE
            }

            override fun onAnimationStart(animation: Animator?) {
                //Do nothing
            }

        })
    }
}
