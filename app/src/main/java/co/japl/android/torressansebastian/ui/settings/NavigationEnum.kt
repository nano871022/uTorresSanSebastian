package co.japl.android.torressansebastian.ui.settings

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import co.japl.android.torressansebastian.R

enum class NavigationEnum(private val id:Int,@StringRes private val nameOf:Int,@DrawableRes private val icon:Int,private val inDrawer:Boolean=false) {
    AdministationPayment(9,R.string.menu_admin_pay, R.drawable.ic_baseline_attach_money_24),
    Garbage(5,R.string.menu_garbage,R.drawable.ic_baseline_restore_from_trash_24,true),
    Location(2,R.string.menu_location,R.drawable.ic_baseline_location_on_24,true),
    Noise(6,R.string.menu_noise,R.drawable.ic_baseline_do_not_disturb_on_total_silence_24,true),
    Parking(3,R.string.menu_parking,R.drawable.ic_baseline_local_parking_24,true),
    PetsOwnerShip(7,R.string.menu_pet_ownership,R.drawable.ic_baseline_pets_24,true),
    PlayGround(4,R.string.menu_playground,R.drawable.ic_baseline_sports_soccer_24,true),
    Repair(8,R.string.menu_repair,R.drawable.ic_baseline_home_repair_service_24,true),
    Schedule(10,R.string.menu_schedule,R.drawable.ic_baseline_calendar_month_24)
    ,Home(1,R.string.menu_home,R.drawable.baseline_home_24,true)
    ,ContactUs(11,R.string.menu_contact_us,R.drawable.ic_baseline_complains,false)
    ,AboutBy(12,R.string.about_by,R.drawable.baseline_person_24,false);

    fun isInDrawer():Boolean{
        return inDrawer
    }

    fun getName():Int{
        return nameOf
    }

    fun getId():Int{
        return id
    }

    fun getIcon():Int{
        return icon
    }
    fun getRoute():String{
        return name
    }

}