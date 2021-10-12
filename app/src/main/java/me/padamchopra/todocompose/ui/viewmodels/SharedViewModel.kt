package me.padamchopra.todocompose.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.padamchopra.todocompose.data.models.ToDoTask
import me.padamchopra.todocompose.data.repositories.ToDoRepository
import me.padamchopra.todocompose.util.SearchAppBarState
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository
): ViewModel() {

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")

    private val _allTasks = MutableStateFlow<List<ToDoTask>>(emptyList())
    val allTasks: StateFlow<List<ToDoTask>> get() = _allTasks

    fun getAllTasks() {
        viewModelScope.launch {
            repository.getAllTasks.collect {
                _allTasks.value = it
            }
        }
    }

    fun openSearchBar() {
        searchAppBarState.value = SearchAppBarState.OPENED
    }

    fun closeSearchBar() {
        searchAppBarState.value = SearchAppBarState.CLOSED
        searchTextState.value = ""
    }

    fun setSearchStringTo(query: String) {
        searchTextState.value = query
    }
}