/* Copyright (C) 2013-2023 TU Dortmund
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

package de.learnlib.algorithm.lsharp.ads;

import net.automatalib.common.util.Pair;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ArenaNode<T, P> {
    public final @Nullable Pair<P, Integer> parent;
    public T value;

    public ArenaNode(Pair<P, Integer> parent, T value) {
        this.parent = parent;
        this.value = value;
    }

    public ArenaNode(T value) {
        this(null, value);
    }

    public void update(T value) {
        this.value = value;
    }
}