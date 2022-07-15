package com.example.pointbuypager

import com.example.pointbuypager.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.stat
import androidx.core.widget.addTextChangedListener
import com.example.pointbuypager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

val  musicArray = arrayOf(
    "5E",
    "Maze",
    "PF1E"
)

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout,  viewPager) { tab, position ->
            tab.text = musicArray[position]
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                when(tabLayout.selectedTabPosition) {
                    0 -> {
                        binding.tvFlexOneStat.text = binding.root.context.resources.getText(R.string.intelligence_sh)
                        binding.tvFlexTwoStat.text = binding.root.context.resources.getText(R.string.wisdom_sh)
                        resetTable(0)
                    }
                    1 -> {
                        binding.tvFlexOneStat.text = binding.root.context.resources.getText(R.string.wits_sh)
                        binding.tvFlexTwoStat.text = binding.root.context.resources.getText(R.string.willpower_sh)
                        resetTable(1)
                    }
                    2 -> {
                        binding.tvFlexOneStat.text = binding.root.context.resources.getText(R.string.intelligence_sh)
                        binding.tvFlexTwoStat.text = binding.root.context.resources.getText(R.string.wisdom_sh)
                        resetTable(2)
                    }
                }

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
        })

        binding.etStrength.addTextChangedListener {
            tableUpdate(1)
        }
        binding.etDexterity.addTextChangedListener {
            tableUpdate(2)
        }
        binding.etConstitution.addTextChangedListener {
            tableUpdate(3)
        }
        binding.etWits.addTextChangedListener {
            tableUpdate(4)
        }
        binding.etWillpower.addTextChangedListener {
            tableUpdate(5)
        }
        binding.etCharisma.addTextChangedListener {
            tableUpdate(6)
        }
    }

    private fun resetTable(mode: Int){
        when(mode){
            0 -> {
                binding.tvStrengthScore.text = getString(R.string.default_stat)
                binding.tvDexterityScore.text = getString(R.string.default_stat)
                binding.tvConstitutionScore.text = getString(R.string.default_stat)
                binding.tvWitsScore.text = getString(R.string.default_stat)
                binding.tvWillpowerScore.text = getString(R.string.default_stat)
                binding.tvCharismaScore.text = getString(R.string.default_stat)
                binding.etStrength.setText(getString(R.string.score_modifier))
                binding.etDexterity.setText(getString(R.string.score_modifier))
                binding.etConstitution.setText(getString(R.string.score_modifier))
                binding.etWits.setText(getString(R.string.score_modifier))
                binding.etWillpower.setText(getString(R.string.score_modifier))
                binding.etCharisma.setText(getString(R.string.score_modifier))

                for(i in 1..6){
                    tableUpdate(i)
                }
            }
            1 -> {
                binding.tvStrengthScore.text = getString(R.string.default_stat)
                binding.tvDexterityScore.text = getString(R.string.default_stat)
                binding.tvConstitutionScore.text = getString(R.string.default_stat)
                binding.tvWitsScore.text = getString(R.string.default_stat)
                binding.tvWillpowerScore.text = getString(R.string.default_stat)
                binding.tvCharismaScore.text = getString(R.string.default_stat)
                binding.etStrength.setText(getString(R.string.score_modifier))
                binding.etDexterity.setText(getString(R.string.score_modifier))
                binding.etConstitution.setText(getString(R.string.score_modifier))
                binding.etWits.setText(getString(R.string.score_modifier))
                binding.etWillpower.setText(getString(R.string.score_modifier))
                binding.etCharisma.setText(getString(R.string.score_modifier))

                for(i in 1..6){
                    tableUpdate(i)
                }
            }
            2 -> {
                binding.tvStrengthScore.text = getString(R.string.default_pathfinder)
                binding.tvDexterityScore.text = getString(R.string.default_pathfinder)
                binding.tvConstitutionScore.text = getString(R.string.default_pathfinder)
                binding.tvWitsScore.text = getString(R.string.default_pathfinder)
                binding.tvWillpowerScore.text = getString(R.string.default_pathfinder)
                binding.tvCharismaScore.text = getString(R.string.default_pathfinder)
                binding.etStrength.setText(getString(R.string.score_modifier))
                binding.etDexterity.setText(getString(R.string.score_modifier))
                binding.etConstitution.setText(getString(R.string.score_modifier))
                binding.etWits.setText(getString(R.string.score_modifier))
                binding.etWillpower.setText(getString(R.string.score_modifier))
                binding.etCharisma.setText(getString(R.string.score_modifier))

                for(i in 1..6){
                    tableUpdate(i)
                }
            }
        }
    }

    private fun tableUpdate(row: Int) {
        var sum = 0
        when(row) {
            1 -> {
                sum = if(binding.etStrength.text.isEmpty() || binding.etStrength.text.toString().equals("-")) {
                    binding.tvStrengthScore.text.toString().toInt()
                } else {
                    binding.etStrength.text.toString().toInt() +
                            binding.tvStrengthScore.text.toString().toInt()
                }
                binding.tvStrengthAdjust.text = sum.toString()
                binding.tvStrengthMod.text = ((sum - 10) / 2).toString()
            }
            2 -> {
                sum = if(binding.etDexterity.text.isEmpty() || binding.etDexterity.text.toString().equals("-")) {
                    binding.tvDexterityScore.text.toString().toInt()
                } else {
                    binding.etDexterity.text.toString().toInt() +
                            binding.tvDexterityScore.text.toString().toInt()
                }
                binding.tvDexterityAdjust.text = sum.toString()
                binding.tvDexterityMod.text = ((sum - 10) / 2).toString()

            }
            3 -> {
                sum = if(binding.etConstitution.text.isEmpty() || binding.etConstitution.text.toString().equals("-")) {
                    binding.tvConstitutionScore.text.toString().toInt()
                } else {
                    binding.etConstitution.text.toString().toInt() +
                            binding.tvConstitutionScore.text.toString().toInt()
                }
                binding.tvConstitutionAdjust.text = sum.toString()
                binding. tvConstitutionMod.text = ((sum - 10) / 2).toString()
            }
            4 -> {
                sum = if(binding.etWits.text.isEmpty() || binding.etWits.text.toString().equals("-")) {
                    binding.tvWitsScore.text.toString().toInt()
                } else {
                    binding.etWits.text.toString().toInt() +
                            binding.tvWitsScore.text.toString().toInt()
                }
                binding.tvWitsAdjust.text = sum.toString()
                binding.tvWitsMod.text = ((sum - 10) / 2).toString()
            }
            5 -> {
                sum = if(binding.etWillpower.text.isEmpty() || binding.etWillpower.text.toString().equals("-")) {
                    binding.tvWillpowerScore.text.toString().toInt()
                } else {
                    binding.etWillpower.text.toString().toInt() +
                            binding.tvWillpowerScore.text.toString().toInt()
                }
                binding.tvWillpowerAdjust.text = sum.toString()
                binding.tvWillpowerMod.text = ((sum - 10) / 2).toString()
            }
            6 -> {
                sum = if(binding.etCharisma.text.isEmpty() || binding.etCharisma.text.toString().equals("-")) {
                    binding.tvCharismaScore.text.toString().toInt()
                } else {
                    binding.etCharisma.text.toString().toInt() +
                            binding.tvCharismaScore.text.toString().toInt()
                }
                binding.tvCharismaAdjust.text = sum.toString()
                binding.tvCharismaMod.text = ((sum - 10) / 2).toString()
            }
        }
    }

    fun updateStat(stat: Int, data: String) {
        when(stat){
            1 -> {
                binding.tvStrengthScore.text = data
                tableUpdate(1)
            }
            2 -> {
                binding.tvDexterityScore.text = data
                tableUpdate(2)

            }
            3 -> {
                binding.tvConstitutionScore.text = data
                tableUpdate(3)
            }
            4 -> {
                binding.tvWitsScore.text = data
                tableUpdate(4)
            }
            5 -> {
                binding.tvWillpowerScore.text = data
                tableUpdate(5)
            }
            6 -> {
                binding.tvCharismaScore.text = data
                tableUpdate(6)
            }
        }
    }
}