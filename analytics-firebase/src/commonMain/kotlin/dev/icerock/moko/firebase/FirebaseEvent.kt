/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */
package dev.icerock.moko.firebase

interface FirebaseEvent

class FirebaseSimpleEvent(
    val id: String? = null,
    val value: String? = null,
) : FirebaseEvent
