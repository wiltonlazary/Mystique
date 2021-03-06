package co.upcurve.mystiquesample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import co.upcurve.mystique.MystiqueAdapter
import co.upcurve.mystique.MystiqueItemPresenter
import co.upcurve.mystique.toMystifiedList
import co.upcurve.mystiquesample.items.PostItem
import co.upcurve.mystiquesample.models.BannerModel
import co.upcurve.mystiquesample.models.PostModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PostItem.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
    }

    override fun onItemClicked(title: String) {
        println("Song Title: $title")
    }

    fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val mystiqueAdapter = MystiqueAdapter<MystiqueItemPresenter>()
        mystiqueAdapter.setItems(getDummyData().toMystifiedList(this))

        recyclerView.adapter = mystiqueAdapter
    }

    /**
     * Loading some dummy data here of types [PostModel] and [BannerModel]
     */
    fun getDummyData(): MutableList<Any> {
        val heterogeneousModelList = mutableListOf<Any>()
        heterogeneousModelList.add(PostModel(title = "Hello",
                imageUrl = "http://www.idolator.com/wp-content/uploads/sites/10/2015/10/adele-hello.jpg"))
        heterogeneousModelList.add(PostModel(title = "Uptown Funk",
                imageUrl = "http://www.robotbutt.com/wp-content/uploads/2015/01/Uptown-Funk.jpg"))
        heterogeneousModelList.add(BannerModel("ADV: Use Kotlin"))
        heterogeneousModelList.add(PostModel(title = "Cold Water",
                imageUrl = "http://www.idolator.com/wp-content/uploads/sites/10/2016/07/major-lazer-cold-water-620x413.jpg"))
        heterogeneousModelList.add(BannerModel("ADV: Visit JetBrains"))

        return heterogeneousModelList
    }
}
