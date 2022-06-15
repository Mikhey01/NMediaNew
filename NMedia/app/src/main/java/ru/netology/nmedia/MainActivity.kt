package ru.netology.nmedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.nmedia.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет - профессий",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов" +
                    " по онлайн-маркетингую Затем появились курсы по дизайну, разработке, " +
                    "аналитике и управлению. Мы растем сами и помогаем расти студентам: от новичков до" +
                    "уверенных профессионалов.но самое важное остается с нами: мы верим, что в каждом" +
                    "уже есть сила, которая заставляет хотетьбольше, целиться выше, бежать быстрее." +
                    "Наша миссия - помочь встать на путь роста и начать цепочку перемен." +
                    " - http://netolo.gy/fyb",
            publisher = "18 мая в 23:47",
            likeByMe = false,
            countLikes = 999U,
        countComment = 0U,
            countShare = 0U,
       countViews = 0U,
        )

        with(binding) {
            avatar.setImageResource(R.drawable.ic_launcher_foreground)

            authorName.text = post.author
            date.text = post.publisher
            textPost.text = post.content
            quantityFavorit.text = Service.likesCounters(post.countLikes)
           // quantity_chart_comments.text = Service.likesCounters(post.countComment)
            quantity_share.text = Service.likesCounters(post.countShare)
            number_views.text = Service.likesCounters(post.countViews)

            textPost.setText(post.content)

            binding.likes.setOnClickListener {
                post.likeByMe = !post.likeByMe
                val imageResId = if (post.likeByMe) {
                                       R.drawable.ic_favorite_24dp
                }
                else R.drawable.outline_favorite_border_24

                run {
                    binding.likes.setImageResource(imageResId)
                    if (post.likeByMe) {
                        post.countLikes++
                    } else {
                        post.countLikes--
                    }
                    quantityFavorit.text = Service.likesCounters(post.countLikes)
                }

            }

            binding.share.setOnClickListener {
                post.countShare++
                quantity_share.text = Service.likesCounters(post.countShare)
            }

            }


        }

    }




