package com.hamza.madar.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.hamza.madar.R
import com.hamza.madar.base.BaseFragment
import com.hamza.madar.databinding.FragmentHomeBinding
import com.hamza.madar.utils.TextInputUtils.validate


class HomeFragment : BaseFragment<FragmentHomeBinding>() {


    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {

        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.add_user)


        handleSaveButton()

    }



    private fun handleSaveButton() {
        binding.saveButton.setOnClickListener {
            if (isValidated()){
                // add to DB
                findNavController().navigate(R.id.action_homeFragment_to_usersFragment)
            }

        }

    }

    private fun isValidated(): Boolean {
        val nameValid = binding.nameTextInputLayout.validate(
            binding.nameEditText.text.toString(),
            getString(R.string.please_enter_name)
        )

        val jobTitleValid = binding.jobTitleTextInputLayout.validate(
            binding.jobTitleEditText.text.toString(),
            getString(R.string.please_enter_job_title)
        )

        val age = binding.ageEditText.text.toString().toIntOrNull()
        val ageValid = if (age == null || age !in 1..120) {
            binding.ageTextInputLayout.error = getString(R.string.please_enter_valid_age_1_120)
            false
        } else {
            binding.ageTextInputLayout.error = null
            true
        }

        val genderValid = binding.rgGender.checkedRadioButtonId != -1
        if (!genderValid) showErrorToast(getString(R.string.please_select_gender))

        return nameValid && jobTitleValid && ageValid && genderValid
    }



}