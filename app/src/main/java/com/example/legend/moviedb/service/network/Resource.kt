package com.example.legend.moviedb.service.network

import com.example.legend.moviedb.service.network.Resource.Status.*


class Resource<T>( val status: Status?, val data: T?,throwable: Throwable?) {
    enum class Status {
        LOADING,
        SUCCESS,
        ERROR
    }

    val isSuccess: Boolean
        get() = status == SUCCESS

    val isLoading: Boolean
        get() = status == LOADING

    val isError: Boolean
        get() = status == ERROR

    companion object {
        fun <T> success(data: T): Resource<T> =  Resource(SUCCESS, data,null)
        fun <T> error(error: Throwable):Resource<T>  = Resource(Status.ERROR, null,error)
        fun <T> loading( data: T?): Resource<T> = Resource(LOADING,data,Throwable())
    }


}
