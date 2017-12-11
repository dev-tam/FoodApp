package net.torora.jtam.foodapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {
    var adapter:FoodAdapter?=null
    var listOfFoods = ArrayList<Food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // load foods
        listOfFoods.add(Food("Coffee","Metus tempor aliquet aliquam ante sagittis per faucibus, phasellus auctor curae mattis torquent suspendisse, ridiculus montes at dui sodales eleifend. Vestibulum cras euismod augue nostra viverra, fringilla volutpat ultrices pretium. Massa scelerisque rutrum ultrices suspendisse molestie aenean nec habitasse iaculis nulla, nibh vehicula venenatis taciti est habitant porta ultricies id.\n",R.drawable.coffee_pot))
        listOfFoods.add(Food("Espresso","Feugiat hac cras nunc auctor magna nulla vitae natoque suspendisse facilisi, faucibus interdum morbi dapibus maecenas turpis laoreet in eleifend ultrices, cum aenean non rhoncus facilisis quam aliquet integer nullam. Massa scelerisque rutrum ultrices suspendisse molestie aenean nec habitasse iaculis nulla, nibh vehicula venenatis taciti est habitant porta ultricies id.\n",R.drawable.espresso))
        listOfFoods.add(Food("French Fries","Odio dignissim tortor habitant tellus dictum molestie hendrerit non fermentum faucibus, penatibus sodales egestas convallis pharetra lectus platea tempor ullamcorper blandit, viverra dapibus iaculis suscipit eget rutrum sollicitudin nam vel.\n Massa scelerisque rutrum ultrices suspendisse molestie aenean nec habitasse iaculis nulla, nibh vehicula venenatis taciti est habitant porta ultricies id.\n",R.drawable.french_fries))
        listOfFoods.add(Food("Honey","At rutrum sem aliquet eleifend netus platea rhoncus penatibus potenti quam nisi torquent, ridiculus hendrerit mauris mollis velit suscipit magna tincidunt donec augue ut. Porta viverra est sapien, risus volutpat.\n Massa scelerisque rutrum ultrices suspendisse molestie aenean nec habitasse iaculis nulla, nibh vehicula venenatis taciti est habitant porta ultricies id.\n",R.drawable.honey))
        listOfFoods.add(Food("Strawbery","Habitant id fringilla ridiculus elementum nibh, lectus integer venenatis senectus neque velit, dignissim malesuada cubilia vivamus. Dictumst pulvinar semper interdum rhoncus mi taciti enim, dictum vestibulum a augue imperdiet euismod. Massa scelerisque rutrum ultrices suspendisse molestie aenean nec habitasse iaculis nulla, nibh vehicula venenatis taciti est habitant porta ultricies id.\n",R.drawable.strawberry_ice_cream))
        listOfFoods.add(Food("Sugar Cubes","Curabitur habitasse pharetra hac erat lacinia duis sodales congue nunc integer, interdum imperdiet natoque ligula potenti nulla massa venenatis ac mus, libero tristique luctus taciti ante nec vulputate nostra facilisis. Massa scelerisque rutrum ultrices suspendisse molestie aenean nec habitasse iaculis nulla, nibh vehicula venenatis taciti est habitant porta ultricies id.\n",R.drawable.sugar_cubes))
        adapter= FoodAdapter(this, listOfFoods)

        gvListFood.adapter=adapter
    }
    class FoodAdapter:BaseAdapter{
        var listOfFood=ArrayList<Food>()
        var context:Context?=null
        constructor(context:Context,listOfFood:ArrayList<Food>):super(){
            this.context=context
            this.listOfFood=listOfFood
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val food=this.listOfFood[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView=inflater.inflate(R.layout.food_ticket, null)
            foodView.ivFoodImage.setImageResource(food.image!!)
            foodView.ivFoodImage.setOnClickListener {
                val intent = Intent(context,FoodDetails::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }
            foodView.tvName.text=food.name!!
            return foodView
        }

        override fun getItem(position: Int): Any {
            return listOfFood[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfFood.size
        }

    }
}
