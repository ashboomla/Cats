package com.example.projectcapitoloneinterview.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.projectcapitoloneinterview.ui.cats.fragments.CatBreedsFragment
import com.example.projectcapitoloneinterview.ui.cats.fragments.ImagesOfCatsFragment

class MainTabAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ImagesOfCatsFragment()
            else -> CatBreedsFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Images"
            else -> "Breeds"

        }
    }
}