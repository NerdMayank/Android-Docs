import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.viewmodel.Blog

class MainViewModel: ViewModel() {
    var lst = MutableLiveData<ArrayList<Blog>>()
    var newlist = arrayListOf<Blog>()

    fun add(blog: Blog){
        newlist.add(blog)
        lst.value=newlist
    }

    fun remove(blog: Blog){
        newlist.remove(blog)
        lst.value=newlist
    }

}