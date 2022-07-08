package com.samiu.lottery.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samiu.lottery.data.entiry.AimCode
import com.samiu.lottery.data.entiry.LotResult
import com.samiu.lottery.data.repository.MxnRepository
import com.samiu.lottery.ui.state.AimUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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

    private val _aimStateFlow = MutableStateFlow(AimUIState())
    val aimStateFlow = _aimStateFlow.asStateFlow()

    fun queryLottery(expect: String, aimCode: AimCode) = viewModelScope.launch {
        repository.queryLottery(expect, aimCode).collectLatest {
            if (it is LotResult.Success) {
//                _aimStateFlow.emit(
//                    AimUIState(
//                        openCode = it.data.openCode,
//                        name = it.data.name, time = it.data.time
//                    )
//                )
                _aimStateFlow.value = _aimStateFlow.value.copy(
                    openCode = it.data.openCode,
                    name = it.data.name,
                    time = it.data.time
                )
            }
        }
    }
}