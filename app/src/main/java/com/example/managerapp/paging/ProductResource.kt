package com.example.managerapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.managerapp.Results
import com.example.managerapp.api.ApiService

class ProductResource(val apiService: ApiService):PagingSource<Int, Results>() {
    override fun getRefreshKey(state: PagingState<Int, Results>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)?:
            state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Results> {
        var position=params.key?:1
        var result=apiService.getpageData(position)
        var pkey=if (position==1) null else position-1
        var nkey=if (position==result.totalPages) null else position+1
        return try {
            LoadResult.Page(
                data=result.results!!,
                prevKey = pkey,
                nextKey = nkey
            )
        }
        catch (e:Exception){
            LoadResult.Error(e)
        }
    }


}