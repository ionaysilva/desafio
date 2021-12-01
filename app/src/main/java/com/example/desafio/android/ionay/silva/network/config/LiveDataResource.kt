//package com.example.desafio.android.ionay.silva.network.config
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Job
//import kotlinx.coroutines.launch
//import kotlin.reflect.KProperty
//
//typealias LiveResource<T> = LiveData<Resource<T>>
//typealias MutableLiveResource<T> = MutableLiveData<Resource<T>>
//
//sealed class Resource<T> {
//    data class Success<T>(val data: T?) : Resource<T>()
//    data class Error<T>(val statusCode: Int?) : Resource<T>()
//    class Loading<T> : Resource<T>()
//
//    companion object {
//        fun <T> success(data: T?): Resource<T> = Success(data)
//        fun <T> error(statusCode: Int?): Resource<T> = Error(statusCode)
//        fun <T> loading(): Resource<T> = Loading()
//    }
//
//}
//
//class GetLiveData<T>(private val data: MutableLiveData<T>) {
//    operator fun getValue(thisRef: Any?, property: KProperty<*>): LiveData<T> {
//        return data
//    }
//}
//
//fun <T> getLiveData(data: MutableLiveData<T>): GetLiveData<T> {
//    return GetLiveData(data)
//}
//
//fun <T> CoroutineScope.launchResource(
//    mutableLiveResource: MutableLiveResource<T> = MutableLiveResource(),
//    data: suspend () -> T?,
//    onSuccess: suspend (T?) -> Unit = {},
//    onError: suspend (Int?, String) -> Unit = { _, _ -> }
//): Job {
//    mutableLiveResource.loading()
//
//    return launch {
//        mutableLiveResource.setupValidationState(data, onSuccess, onError)
//    }
//}
//
//fun <T> MutableLiveResource<T>.loading() {
//    postValue(Resource.loading())
//}
//
//
//private suspend fun <T> MutableLiveResource<T>.setupValidationState(
//    data: suspend () -> T?,
//    onSuccess: suspend (T?) -> Unit = {},
//    onError: suspend (Int, String) -> Unit = { _, _ -> }
//) {
//    try {
//        data.invoke().also {
//            this.success(it)
//            onSuccess.invoke(it)
//        }
//    } catch (e: HttpException) {
//        this.error(e.code())
//        onError.invoke(e.code(), e.message())
//        FirebaseCrashlytics.getInstance().recordException(e)
//        Timber.e(e)
//    } catch (e: Exception) {
//        this.error(0)
//        onError.invoke(0, "")
//        FirebaseCrashlytics.getInstance().recordException(e)
//        Timber.e(e)
//    }
//}
//
//
//
