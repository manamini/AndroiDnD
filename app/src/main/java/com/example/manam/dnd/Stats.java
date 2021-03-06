package com.example.manam.dnd;

/**
 * Created by manam on 5/11/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Stats extends Fragment {

    static EditText strengthEdit, dexterityEdit, constitutionEdit, intelligenceEdit, wisdomEdit, charismaEdit;

    //Saves proficiency
    static CheckBox strSave, dexSave, conSave, intSave, wisSave, chrSave;
    //Skill proficiency based on attribute
    static CheckBox athletics;
    static CheckBox acrobatics, sleight, stealth;
    static CheckBox arcana, history, investigation, nature, religion;
    static CheckBox animal, insight, medicine, perception, survival;
    static CheckBox deception, intimidation, performance, persuasion;

    //Attribute Bonuses
    static TextView strengthBonus, dexterityBonus, constitutionBonus, intelligenceBonus, wisdomBonus, charismaBonus;
    //Save Bonuses
    TextView strSaveBonus, dexSaveBonus, conSaveBonus, intSaveBonus, wisSaveBonus, chrSaveBonus;
    //Skill Bonuses based on attribute
    TextView athleticsBonus;
    TextView acrobaticsBonus, sleightBonus, stealthBonus;
    TextView arcanaBonus, historyBonus, investigationBonus, natureBonus, religionBonus;
    TextView animalBonus, insightBonus, medicineBonus, perceptionBonus, survivalBonus;
    TextView deceptionBonus, intimidationBonus, performanceBonus, persuasionBonus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.statstab, container, false);


        // Attribute Text edits
        strengthEdit = (EditText) rootView.findViewById(R.id.strscore);
        dexterityEdit = (EditText) rootView.findViewById(R.id.dexscore);
        constitutionEdit = (EditText) rootView.findViewById(R.id.conscore);
        intelligenceEdit = (EditText) rootView.findViewById(R.id.intscore);
        wisdomEdit = (EditText) rootView.findViewById(R.id.wisscore);
        charismaEdit = (EditText) rootView.findViewById(R.id.chrscore);

        //Attribute bonus textviews
        strengthBonus = (TextView) rootView.findViewById(R.id.strbonus);
        dexterityBonus = (TextView) rootView.findViewById(R.id.dexbonus);
        constitutionBonus = (TextView) rootView.findViewById(R.id.conbonus);
        intelligenceBonus = (TextView) rootView.findViewById(R.id.intbonus);
        wisdomBonus = (TextView) rootView.findViewById(R.id.wisbonus);
        charismaBonus = (TextView) rootView.findViewById(R.id.chrbonus);

        // Attribute save checkboxes
        strSave = (CheckBox) rootView.findViewById(R.id.strsave);
        dexSave = (CheckBox) rootView.findViewById(R.id.dexsave);
        conSave = (CheckBox) rootView.findViewById(R.id.consave);
        intSave = (CheckBox) rootView.findViewById(R.id.intsave);
        wisSave = (CheckBox) rootView.findViewById(R.id.wissave);
        chrSave = (CheckBox) rootView.findViewById(R.id.chrsave);

        // Attribute save bonus textviews
        strSaveBonus = (TextView) rootView.findViewById(R.id.strsavebonus);
        dexSaveBonus = (TextView) rootView.findViewById(R.id.dexsavebonus);
        conSaveBonus = (TextView) rootView.findViewById(R.id.consavebonus);
        intSaveBonus = (TextView) rootView.findViewById(R.id.intsavebonus);
        wisSaveBonus = (TextView) rootView.findViewById(R.id.wissavebonus);
        chrSaveBonus = (TextView) rootView.findViewById(R.id.chrsavebonus);

        // Skill proficiency checkboxes
        athletics = (CheckBox) rootView.findViewById(R.id.athletics);
        acrobatics = (CheckBox) rootView.findViewById(R.id.acrobatics);
        sleight = (CheckBox) rootView.findViewById(R.id.sleight);
        stealth = (CheckBox) rootView.findViewById(R.id.stealth);
        arcana = (CheckBox) rootView.findViewById(R.id.arcana);
        history = (CheckBox) rootView.findViewById(R.id.history);
        investigation = (CheckBox) rootView.findViewById(R.id.investigation);
        nature = (CheckBox) rootView.findViewById(R.id.nature);
        religion = (CheckBox) rootView.findViewById(R.id.religion);
        animal = (CheckBox) rootView.findViewById(R.id.animal);
        insight = (CheckBox) rootView.findViewById(R.id.insight);
        medicine = (CheckBox) rootView.findViewById(R.id.medicine);
        perception = (CheckBox) rootView.findViewById(R.id.perception);
        survival = (CheckBox) rootView.findViewById(R.id.survival);
        deception = (CheckBox) rootView.findViewById(R.id.deception);
        intimidation = (CheckBox) rootView.findViewById(R.id.intimidation);
        performance = (CheckBox) rootView.findViewById(R.id.performance);
        persuasion = (CheckBox) rootView.findViewById(R.id.persuasion);

        //Skill bonus textviews
        athleticsBonus = (TextView) rootView.findViewById(R.id.athleticsbonus);
        acrobaticsBonus = (TextView) rootView.findViewById(R.id.acrobaticsbonus);
        sleightBonus = (TextView) rootView.findViewById(R.id.sleightbonus);
        stealthBonus = (TextView) rootView.findViewById(R.id.stealthbonus);
        arcanaBonus = (TextView) rootView.findViewById(R.id.arcanabonus);
        historyBonus = (TextView) rootView.findViewById(R.id.historybonus);
        investigationBonus = (TextView) rootView.findViewById(R.id.investigationbonus);
        natureBonus = (TextView) rootView.findViewById(R.id.naturebonus);
        religionBonus = (TextView) rootView.findViewById(R.id.religionbonus);
        animalBonus = (TextView) rootView.findViewById(R.id.animalbonus);
        insightBonus = (TextView) rootView.findViewById(R.id.insightbonus);
        medicineBonus = (TextView) rootView.findViewById(R.id.medicinebonus);
        perceptionBonus = (TextView) rootView.findViewById(R.id.perceptionbonus);
        survivalBonus = (TextView) rootView.findViewById(R.id.survivalbonus);
        deceptionBonus = (TextView) rootView.findViewById(R.id.deceptionbonus);
        intimidationBonus = (TextView) rootView.findViewById(R.id.intimidationbonus);
        performanceBonus = (TextView) rootView.findViewById(R.id.performancebonus);
        persuasionBonus = (TextView) rootView.findViewById(R.id.persuasionbonus);


        //Text change Listeners
        strengthEdit.addTextChangedListener(strEditWatcher);
        dexterityEdit.addTextChangedListener(dexEditWatcher);
        constitutionEdit.addTextChangedListener(conEditWatcher);
        intelligenceEdit.addTextChangedListener(intEditWatcher);
        wisdomEdit.addTextChangedListener(wisEditWatcher);
        charismaEdit.addTextChangedListener(chrEditWatcher);

        //Checkbox listeners organized by attribute
        FillOnCheckedListener(strSave, strSaveBonus, strengthBonus);
        FillOnCheckedListener(athletics, athleticsBonus, strengthBonus);
        FillOnCheckedListener(dexSave, dexSaveBonus, dexterityBonus);
        FillOnCheckedListener(acrobatics, acrobaticsBonus, dexterityBonus);
        FillOnCheckedListener(sleight, sleightBonus, dexterityBonus);
        FillOnCheckedListener(stealth, stealthBonus, dexterityBonus);
        FillOnCheckedListener(conSave, conSaveBonus, constitutionBonus);
        FillOnCheckedListener(intSave, intSaveBonus, intelligenceBonus);
        FillOnCheckedListener(arcana, arcanaBonus, intelligenceBonus);
        FillOnCheckedListener(history, historyBonus, intelligenceBonus);
        FillOnCheckedListener(investigation, investigationBonus, intelligenceBonus);
        FillOnCheckedListener(nature, natureBonus, intelligenceBonus);
        FillOnCheckedListener(religion, religionBonus, intelligenceBonus);
        FillOnCheckedListener(wisSave, wisSaveBonus, wisdomBonus);
        FillOnCheckedListener(animal, animalBonus, wisdomBonus);
        FillOnCheckedListener(insight, insightBonus, wisdomBonus);
        FillOnCheckedListener(medicine, medicineBonus, wisdomBonus);
        FillOnCheckedListener(perception, perceptionBonus, wisdomBonus);
        FillOnCheckedListener(survival, survivalBonus, wisdomBonus);
        FillOnCheckedListener(chrSave, chrSaveBonus, charismaBonus);
        FillOnCheckedListener(deception, deceptionBonus, charismaBonus);
        FillOnCheckedListener(intimidation, intimidationBonus, charismaBonus);
        FillOnCheckedListener(performance, performanceBonus, charismaBonus);
        FillOnCheckedListener(persuasion, persuasionBonus, charismaBonus);
        //
        // End Checkbox listeners
        //

        return rootView;
    }

    private void FillOnCheckedListener(CheckBox checkBox, final TextView textView, final TextView attribute){
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FillBonuses(textView, isChecked, attribute);
            }
        });
    }

    private void FillBonuses(TextView textView, boolean isChecked, TextView attribute){
        if (isChecked) {
            if (textView.getText().length() > 0) {
                if (Integer.parseInt(textView.getText().toString()) + Integer.parseInt(MainActivity.profic) < 0) {
                    textView.setText("-" + (Integer.parseInt(textView.getText().toString()) + Integer.parseInt(MainActivity.profic)));
                } else if (Integer.parseInt(textView.getText().toString()) + Integer.parseInt(MainActivity.profic) == 0) {
                    textView.setText("0");
                } else {
                    textView.setText("+" + (Integer.parseInt(textView.getText().toString()) + Integer.parseInt(MainActivity.profic)));
                }
            }
        } else if (!isChecked) {
            textView.setText(attribute.getText().toString());
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void setStrBonus(String bonus) {
        strengthBonus.setText(bonus);
        strSaveBonus.setText(bonus);
        athleticsBonus.setText(bonus);
    }

    private void setDexBonus(String bonus) {
        dexterityBonus.setText(bonus);
        dexSaveBonus.setText(bonus);
        acrobaticsBonus.setText(bonus);
        sleightBonus.setText(bonus);
        stealthBonus.setText(bonus);
    }

    private void setConBonus(String bonus) {
        constitutionBonus.setText(bonus);
        conSaveBonus.setText(bonus);
    }

    private void setIntBonus(String bonus) {
        intelligenceBonus.setText(bonus);
        intSaveBonus.setText(bonus);
        arcanaBonus.setText(bonus);
        historyBonus.setText(bonus);
        investigationBonus.setText(bonus);
        natureBonus.setText(bonus);
        religionBonus.setText(bonus);
    }

    private void setWisBonus(String bonus) {
        wisdomBonus.setText(bonus);
        wisSaveBonus.setText(bonus);
        animalBonus.setText(bonus);
        insightBonus.setText(bonus);
        medicineBonus.setText(bonus);
        perceptionBonus.setText(bonus);
        survivalBonus.setText(bonus);
    }

    private void setChrBonus(String bonus) {
        charismaBonus.setText(bonus);
        chrSaveBonus.setText(bonus);
        deceptionBonus.setText(bonus);
        intimidationBonus.setText(bonus);
        performanceBonus.setText(bonus);
        persuasionBonus.setText(bonus);
    }

    private final TextWatcher strEditWatcher = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            if (strengthEdit.getText().toString().length() > 0) {
                if (Integer.parseInt(strengthEdit.getText().toString()) >= 6 && Integer.parseInt(strengthEdit.getText().toString()) < 8) {
                    setStrBonus("-2");
                } else if (Integer.parseInt(strengthEdit.getText().toString()) >= 8 && Integer.parseInt(strengthEdit.getText().toString()) < 10) {
                    setStrBonus("-1");
                } else if (Integer.parseInt(strengthEdit.getText().toString()) >= 10 && Integer.parseInt(strengthEdit.getText().toString()) < 12) {
                    setStrBonus("0");
                } else if (Integer.parseInt(strengthEdit.getText().toString()) >= 12 && Integer.parseInt(strengthEdit.getText().toString()) < 14) {
                    setStrBonus("+1");
                } else if (Integer.parseInt(strengthEdit.getText().toString()) >= 14 && Integer.parseInt(strengthEdit.getText().toString()) < 16) {
                    setStrBonus("+2");
                } else if (Integer.parseInt(strengthEdit.getText().toString()) >= 16 && Integer.parseInt(strengthEdit.getText().toString()) < 18) {
                    setStrBonus("+3");
                } else if (Integer.parseInt(strengthEdit.getText().toString()) >= 18 && Integer.parseInt(strengthEdit.getText().toString()) < 20) {
                    setStrBonus("+4");
                } else if (Integer.parseInt(strengthEdit.getText().toString()) >= 20 && Integer.parseInt(strengthEdit.getText().toString()) < 22) {
                    setStrBonus("+5");
                } else if (Integer.parseInt(strengthEdit.getText().toString()) >= 22 && Integer.parseInt(strengthEdit.getText().toString()) < 24) {
                    setStrBonus("+6");
                } else if (Integer.parseInt(strengthEdit.getText().toString()) >= 24 && Integer.parseInt(strengthEdit.getText().toString()) < 26) {
                    setStrBonus("+7");
                } else if (Integer.parseInt(strengthEdit.getText().toString()) >= 26 && Integer.parseInt(strengthEdit.getText().toString()) < 28) {
                    setStrBonus("+8");
                } else if (Integer.parseInt(strengthEdit.getText().toString()) >= 28 && Integer.parseInt(strengthEdit.getText().toString()) < 30) {
                    setStrBonus("+9");
                } else if (Integer.parseInt(strengthEdit.getText().toString()) >= 30) {
                    setStrBonus("+10");
                }
            }
        }
    };

    private final TextWatcher dexEditWatcher = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            if (dexterityEdit.getText().toString().length() > 0) {
                if (Integer.parseInt(dexterityEdit.getText().toString()) >= 6 && Integer.parseInt(dexterityEdit.getText().toString()) < 8) {
                    setDexBonus("-2");
                } else if (Integer.parseInt(dexterityEdit.getText().toString()) >= 8 && Integer.parseInt(dexterityEdit.getText().toString()) < 10) {
                    setDexBonus("-1");
                } else if (Integer.parseInt(dexterityEdit.getText().toString()) >= 10 && Integer.parseInt(dexterityEdit.getText().toString()) < 12) {
                    setDexBonus("0");
                } else if (Integer.parseInt(dexterityEdit.getText().toString()) >= 12 && Integer.parseInt(dexterityEdit.getText().toString()) < 14) {
                    setDexBonus("+1");
                } else if (Integer.parseInt(dexterityEdit.getText().toString()) >= 14 && Integer.parseInt(dexterityEdit.getText().toString()) < 16) {
                    setDexBonus("+2");
                } else if (Integer.parseInt(dexterityEdit.getText().toString()) >= 16 && Integer.parseInt(dexterityEdit.getText().toString()) < 18) {
                    setDexBonus("+3");
                } else if (Integer.parseInt(dexterityEdit.getText().toString()) >= 18 && Integer.parseInt(dexterityEdit.getText().toString()) < 20) {
                    setDexBonus("+4");
                } else if (Integer.parseInt(dexterityEdit.getText().toString()) >= 20 && Integer.parseInt(dexterityEdit.getText().toString()) < 22) {
                    setDexBonus("+5");
                } else if (Integer.parseInt(dexterityEdit.getText().toString()) >= 22 && Integer.parseInt(dexterityEdit.getText().toString()) < 24) {
                    setDexBonus("+6");
                } else if (Integer.parseInt(dexterityEdit.getText().toString()) >= 24 && Integer.parseInt(dexterityEdit.getText().toString()) < 26) {
                    setDexBonus("+7");
                } else if (Integer.parseInt(dexterityEdit.getText().toString()) >= 26 && Integer.parseInt(dexterityEdit.getText().toString()) < 28) {
                    setDexBonus("+8");
                } else if (Integer.parseInt(dexterityEdit.getText().toString()) >= 28 && Integer.parseInt(dexterityEdit.getText().toString()) < 30) {
                    setDexBonus("+9");
                } else if (Integer.parseInt(dexterityEdit.getText().toString()) >= 30) {
                    setDexBonus("+10");
                }
            }
        }


    };

    private final TextWatcher conEditWatcher = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            if (constitutionEdit.getText().toString().length() > 0) {
                if (Integer.parseInt(constitutionEdit.getText().toString()) >= 6 && Integer.parseInt(strengthEdit.getText().toString()) < 8 && strengthEdit.getText().toString().equals("")) {
                    setConBonus("-2");
                } else if (Integer.parseInt(constitutionEdit.getText().toString()) >= 8 && Integer.parseInt(constitutionEdit.getText().toString()) < 10) {
                    setConBonus("-1");
                } else if (Integer.parseInt(constitutionEdit.getText().toString()) >= 10 && Integer.parseInt(constitutionEdit.getText().toString()) < 12) {
                    setConBonus("0");
                } else if (Integer.parseInt(constitutionEdit.getText().toString()) >= 12 && Integer.parseInt(constitutionEdit.getText().toString()) < 14) {
                    setConBonus("+1");
                } else if (Integer.parseInt(constitutionEdit.getText().toString()) >= 14 && Integer.parseInt(constitutionEdit.getText().toString()) < 16) {
                    setConBonus("+2");
                } else if (Integer.parseInt(constitutionEdit.getText().toString()) >= 16 && Integer.parseInt(constitutionEdit.getText().toString()) < 18) {
                    setConBonus("+3");
                } else if (Integer.parseInt(constitutionEdit.getText().toString()) >= 18 && Integer.parseInt(constitutionEdit.getText().toString()) < 20) {
                    setConBonus("+4");
                } else if (Integer.parseInt(constitutionEdit.getText().toString()) >= 20 && Integer.parseInt(constitutionEdit.getText().toString()) < 22) {
                    setConBonus("+5");
                } else if (Integer.parseInt(constitutionEdit.getText().toString()) >= 22 && Integer.parseInt(constitutionEdit.getText().toString()) < 24) {
                    setConBonus("+6");
                } else if (Integer.parseInt(constitutionEdit.getText().toString()) >= 24 && Integer.parseInt(constitutionEdit.getText().toString()) < 26) {
                    setConBonus("+7");
                } else if (Integer.parseInt(constitutionEdit.getText().toString()) >= 26 && Integer.parseInt(constitutionEdit.getText().toString()) < 28) {
                    setConBonus("+8");
                } else if (Integer.parseInt(constitutionEdit.getText().toString()) >= 28 && Integer.parseInt(constitutionEdit.getText().toString()) < 30) {
                    setConBonus("+9");
                } else if (Integer.parseInt(constitutionEdit.getText().toString()) >= 30) {
                    setConBonus("+10");
                }
            }
        }


    };

    private final TextWatcher intEditWatcher = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            if (intelligenceEdit.getText().toString().length() > 0) {
                if (Integer.parseInt(intelligenceEdit.getText().toString()) >= 6 && Integer.parseInt(intelligenceEdit.getText().toString()) < 8) {
                    setIntBonus("-2");
                } else if (Integer.parseInt(intelligenceEdit.getText().toString()) >= 8 && Integer.parseInt(intelligenceEdit.getText().toString()) < 10) {
                    setIntBonus("-1");
                } else if (Integer.parseInt(intelligenceEdit.getText().toString()) >= 10 && Integer.parseInt(intelligenceEdit.getText().toString()) < 12) {
                    setIntBonus("0");
                } else if (Integer.parseInt(intelligenceEdit.getText().toString()) >= 12 && Integer.parseInt(intelligenceEdit.getText().toString()) < 14) {
                    setIntBonus("+1");
                } else if (Integer.parseInt(intelligenceEdit.getText().toString()) >= 14 && Integer.parseInt(intelligenceEdit.getText().toString()) < 16) {
                    setIntBonus("+2");
                } else if (Integer.parseInt(intelligenceEdit.getText().toString()) >= 16 && Integer.parseInt(intelligenceEdit.getText().toString()) < 18) {
                    setIntBonus("+3");
                } else if (Integer.parseInt(intelligenceEdit.getText().toString()) >= 18 && Integer.parseInt(intelligenceEdit.getText().toString()) < 20) {
                    setIntBonus("+4");
                } else if (Integer.parseInt(intelligenceEdit.getText().toString()) >= 20 && Integer.parseInt(intelligenceEdit.getText().toString()) < 22) {
                    setIntBonus("+5");
                } else if (Integer.parseInt(intelligenceEdit.getText().toString()) >= 22 && Integer.parseInt(intelligenceEdit.getText().toString()) < 24) {
                    setIntBonus("+6");
                } else if (Integer.parseInt(intelligenceEdit.getText().toString()) >= 24 && Integer.parseInt(intelligenceEdit.getText().toString()) < 26) {
                    setIntBonus("+7");
                } else if (Integer.parseInt(intelligenceEdit.getText().toString()) >= 26 && Integer.parseInt(intelligenceEdit.getText().toString()) < 28) {
                    setIntBonus("+8");
                } else if (Integer.parseInt(intelligenceEdit.getText().toString()) >= 28 && Integer.parseInt(intelligenceEdit.getText().toString()) < 30) {
                    setIntBonus("+9");
                } else if (Integer.parseInt(intelligenceEdit.getText().toString()) >= 30) {
                    setIntBonus("+10");
                }
            }
        }


    };

    private final TextWatcher wisEditWatcher = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            if (wisdomEdit.getText().toString().length() > 0) {
                if (Integer.parseInt(wisdomEdit.getText().toString()) >= 6 && Integer.parseInt(wisdomEdit.getText().toString()) < 8) {
                    setWisBonus("-2");
                } else if (Integer.parseInt(wisdomEdit.getText().toString()) >= 8 && Integer.parseInt(wisdomEdit.getText().toString()) < 10) {
                    setWisBonus("-1");
                } else if (Integer.parseInt(wisdomEdit.getText().toString()) >= 10 && Integer.parseInt(wisdomEdit.getText().toString()) < 12) {
                    setWisBonus("0");
                } else if (Integer.parseInt(wisdomEdit.getText().toString()) >= 12 && Integer.parseInt(wisdomEdit.getText().toString()) < 14) {
                    setWisBonus("+1");
                } else if (Integer.parseInt(wisdomEdit.getText().toString()) >= 14 && Integer.parseInt(wisdomEdit.getText().toString()) < 16) {
                    setWisBonus("+2");
                } else if (Integer.parseInt(wisdomEdit.getText().toString()) >= 16 && Integer.parseInt(wisdomEdit.getText().toString()) < 18) {
                    setWisBonus("+3");
                } else if (Integer.parseInt(wisdomEdit.getText().toString()) >= 18 && Integer.parseInt(wisdomEdit.getText().toString()) < 20) {
                    setWisBonus("+4");
                } else if (Integer.parseInt(wisdomEdit.getText().toString()) >= 20 && Integer.parseInt(wisdomEdit.getText().toString()) < 22) {
                    setWisBonus("+5");
                } else if (Integer.parseInt(wisdomEdit.getText().toString()) >= 22 && Integer.parseInt(wisdomEdit.getText().toString()) < 24) {
                    setWisBonus("+6");
                } else if (Integer.parseInt(wisdomEdit.getText().toString()) >= 24 && Integer.parseInt(wisdomEdit.getText().toString()) < 26) {
                    setWisBonus("+7");
                } else if (Integer.parseInt(wisdomEdit.getText().toString()) >= 26 && Integer.parseInt(wisdomEdit.getText().toString()) < 28) {
                    setWisBonus("+8");
                } else if (Integer.parseInt(wisdomEdit.getText().toString()) >= 28 && Integer.parseInt(wisdomEdit.getText().toString()) < 30) {
                    setWisBonus("+9");
                } else if (Integer.parseInt(wisdomEdit.getText().toString()) >= 30) {
                    setWisBonus("+10");
                }
            }
        }


    };

    private final TextWatcher chrEditWatcher = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            if (charismaEdit.getText().toString().length() > 0) {
                if (Integer.parseInt(charismaEdit.getText().toString()) >= 6 && Integer.parseInt(charismaEdit.getText().toString()) < 8) {
                    setChrBonus("-2");
                } else if (Integer.parseInt(charismaEdit.getText().toString()) >= 8 && Integer.parseInt(charismaEdit.getText().toString()) < 10) {
                    setChrBonus("-1");
                } else if (Integer.parseInt(charismaEdit.getText().toString()) >= 10 && Integer.parseInt(charismaEdit.getText().toString()) < 12) {
                    setChrBonus("0");
                } else if (Integer.parseInt(charismaEdit.getText().toString()) >= 12 && Integer.parseInt(charismaEdit.getText().toString()) < 14) {
                    setChrBonus("+1");
                } else if (Integer.parseInt(charismaEdit.getText().toString()) >= 14 && Integer.parseInt(charismaEdit.getText().toString()) < 16) {
                    setChrBonus("+2");
                } else if (Integer.parseInt(charismaEdit.getText().toString()) >= 16 && Integer.parseInt(charismaEdit.getText().toString()) < 18) {
                    setChrBonus("+3");
                } else if (Integer.parseInt(charismaEdit.getText().toString()) >= 18 && Integer.parseInt(charismaEdit.getText().toString()) < 20) {
                    setChrBonus("+4");
                } else if (Integer.parseInt(charismaEdit.getText().toString()) >= 20 && Integer.parseInt(charismaEdit.getText().toString()) < 22) {
                    setChrBonus("+5");
                } else if (Integer.parseInt(charismaEdit.getText().toString()) >= 22 && Integer.parseInt(charismaEdit.getText().toString()) < 24) {
                    setChrBonus("+6");
                } else if (Integer.parseInt(charismaEdit.getText().toString()) >= 24 && Integer.parseInt(charismaEdit.getText().toString()) < 26) {
                    setChrBonus("+7");
                } else if (Integer.parseInt(charismaEdit.getText().toString()) >= 26 && Integer.parseInt(charismaEdit.getText().toString()) < 28) {
                    setChrBonus("+8");
                } else if (Integer.parseInt(charismaEdit.getText().toString()) >= 28 && Integer.parseInt(charismaEdit.getText().toString()) < 30) {
                    setChrBonus("+9");
                } else if (Integer.parseInt(charismaEdit.getText().toString()) >= 30) {
                    setChrBonus("+10");
                }
            }
        }


    };


}
