package com.samiu.lottery.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samiu.lottery.data.entiry.AimCode
import com.samiu.lottery.data.entiry.LotResult
import com.samiu.lottery.data.repository.MxnRepository
import com.samiu.lottery.ui.state.AimState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author samiu
 * @email samiuzhong@outlook.com
 */
@HiltViewModel
class MxnViewModel @Inject constructor(
    private val repository: MxnRepository
) : ViewModel() {

    private val _aimState = MutableLiveData<AimState>()
    val aimState: LiveData<AimState>
        get() = _aimState

    fun queryLottery(expect: String, aimCode: AimCode) = viewModelScope.launch {
        repository.queryLottery(expect, aimCode).collectLatest {
            if (it is LotResult.Success) {
                _aimState.postValue(
                    AimState(
                        openCode = it.data.openCode,
                        name = it.data.name,
                        time = it.data.time
                    )
                )
            }
        }
    }
}