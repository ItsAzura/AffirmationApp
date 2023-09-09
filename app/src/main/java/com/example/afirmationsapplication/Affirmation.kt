package com.example.afirmationsapplication

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation (
    @StringRes val stringResourceId: Int,
    //Ràng buộc thuộc tính stringResourceId sẽ nhận res/string
    @DrawableRes val imageResourceId: Int
    //Ràng buộc thuộc tính imageResourceId sẽ nhận res/drawable
)

