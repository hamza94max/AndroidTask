package com.hamza.madar.ui.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hamza.madar.R
import com.hamza.madar.base.BaseFragment
import com.hamza.madar.databinding.FragmentUsersBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UsersFragment : BaseFragment<FragmentUsersBinding>() {

    private val userViewModel: UserViewModel by viewModels()

    private lateinit var usersAdapter: UsersAdapter

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentUsersBinding
        get() = FragmentUsersBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {

        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Users"
        setUpUsersRecyclerView()

    }

    private fun setUpUsersRecyclerView() {
        usersAdapter = UsersAdapter()
        binding.usersRecyclerView.adapter = usersAdapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                userViewModel.users.collect { userList ->
                    usersAdapter.differ.submitList(userList)
                }
            }
        }
    }


}