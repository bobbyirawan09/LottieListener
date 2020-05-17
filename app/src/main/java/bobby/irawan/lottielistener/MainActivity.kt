package bobby.irawan.lottielistener

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lottie_animation_view.setAnimationFromUrl("https://assets7.lottiefiles.com/private_files/lf30_yP8raD.json")
        lottie_animation_view.addAnimatorUpdateListener {
            val progress = (it.animatedValue as Float * 100).toInt()
            text_view_progress.text = progress.toString()
            if (progress >= 50 && progress != 0) {
                lottie_animation_view.pauseAnimation()
                text_view_information.text = "Already hit 50%"
            } else {
                text_view_information.text = ""
            }
        }

        lottie_animation_view.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                Toast.makeText(this@MainActivity, "Start over the animation", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onAnimationEnd(animation: Animator?) {
                Toast.makeText(this@MainActivity, "Animation is end", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationCancel(animation: Animator?) {
                Toast.makeText(this@MainActivity, "Animation is cancelled", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onAnimationStart(animation: Animator?) {
                Toast.makeText(this@MainActivity, "Start the animation", Toast.LENGTH_SHORT).show()
            }

        })
    }
}
