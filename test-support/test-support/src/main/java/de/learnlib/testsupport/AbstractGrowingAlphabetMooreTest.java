/* Copyright (C) 2013-2024 TU Dortmund University
 * This file is part of LearnLib, http://www.learnlib.de/.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.learnlib.testsupport;

import java.util.Collection;
import java.util.Random;

import de.learnlib.algorithm.LearningAlgorithm;
import de.learnlib.oracle.MembershipOracle.MooreMembershipOracle;
import de.learnlib.oracle.membership.MooreSimulatorOracle;
import net.automatalib.alphabet.Alphabet;
import net.automatalib.alphabet.SupportsGrowingAlphabet;
import net.automatalib.alphabet.impl.Alphabets;
import net.automatalib.automaton.transducer.MooreMachine;
import net.automatalib.util.automaton.random.RandomAutomata;
import net.automatalib.word.Word;

public abstract class AbstractGrowingAlphabetMooreTest<L extends SupportsGrowingAlphabet<Character> & LearningAlgorithm<MooreMachine<?, Character, ?, Character>, Character, Word<Character>>>
        extends AbstractGrowingAlphabetTest<L, MooreMachine<?, Character, ?, Character>, MooreMembershipOracle<Character, Character>, Character, Word<Character>> {

    @Override
    protected Alphabet<Character> getInitialAlphabet() {
        return Alphabets.characters('0', '4');
    }

    @Override
    protected Collection<Character> getAlphabetExtensions() {
        return Alphabets.characters('5', '9');
    }

    @Override
    protected MooreMachine<?, Character, ?, Character> getTarget(Alphabet<Character> alphabet) {
        return RandomAutomata.randomMoore(new Random(RANDOM_SEED),
                                          DEFAULT_AUTOMATON_SIZE,
                                          alphabet,
                                          Alphabets.characters('a', 'f'));
    }

    @Override
    protected MooreMembershipOracle<Character, Character> getOracle(MooreMachine<?, Character, ?, Character> target) {
        return new MooreSimulatorOracle<>(target);
    }
}