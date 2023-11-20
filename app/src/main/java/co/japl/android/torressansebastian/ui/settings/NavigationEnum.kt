package co.japl.android.torressansebastian.ui.settings

import co.japl.android.torressansebastian.R

enum class NavigationEnum(private val id:Int, private val icon:Int,private val inDrawer:Boolean=false) {
    AdministationPayment(9, R.drawable.ic_baseline_attach_money_24),
    Garbage(5,R.drawable.ic_baseline_restore_from_trash_24,true),
    Location(2,R.drawable.ic_baseline_location_on_24,true),
    Noise(6,R.drawable.ic_baseline_do_not_disturb_on_total_silence_24,true),
    Parking(3,R.drawable.ic_baseline_local_parking_24,true),
    PetsOwnerShip(7,R.drawable.ic_baseline_pets_24,true),
    PlayGround(4,R.drawable.ic_baseline_sports_soccer_24,true),
    Repair(8,R.drawable.ic_baseline_home_repair_service_24,true),
    Schedule(10,R.drawable.ic_baseline_calendar_month_24)
    ,Home(1,R.drawable.baseline_home_24,true);

    fun isInDrawer():Boolean{
        return inDrawer
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