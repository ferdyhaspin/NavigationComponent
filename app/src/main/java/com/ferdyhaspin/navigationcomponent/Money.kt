package com.ferdyhaspin.navigationcomponent

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

/**
 * Created by ferdyhaspin on 24/03/20.
 * Copyright (c) 2020 Navigation Component All rights reserved.
 */

@Parcelize
data class Money(
    val amount: BigDecimal
) : Parcelable