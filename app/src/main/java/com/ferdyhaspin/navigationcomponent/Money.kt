package com.ferdyhaspin.navigationcomponent

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

/**
 * Created by ferdyhaspin & ilhamelmujib on 24/03/20.
 * Copyright (c) 2020 Bank Syariah Mandiri - Super Apps All rights reserved.
 */

@Parcelize
data class Money(
    val amount: BigDecimal
) : Parcelable