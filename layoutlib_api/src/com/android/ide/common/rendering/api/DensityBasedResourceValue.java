/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.ide.common.rendering.api;

import com.android.layoutlib.api.IDensityBasedResourceValue;
import com.android.resources.ResourceType;

@SuppressWarnings("deprecation")
public class DensityBasedResourceValue extends ResourceValue implements IDensityBasedResourceValue {

    private com.android.resources.Density mDensity;

    public DensityBasedResourceValue(ResourceType type, String name, String value,
            com.android.resources.Density density, boolean isFramework) {
        super(type, name, value, isFramework);
        mDensity = density;
    }

    /**
     * Returns the density for which this resource is configured.
     * @return the density.
     */
    public com.android.resources.Density getResourceDensity() {
        return mDensity;
    }

    /** Legacy method, do not call
     * @deprecated use {@link #getResourceDensity()} instead.
     */
    public Density getDensity() {
        return Density.getEnum(mDensity.getDpiValue());
    }

    @Override
    public String toString() {
        return "DensityBasedResourceValue ["
                + getResourceType() + "/" + getName() + " = " + getValue()
                + " (density:" + mDensity +", framework:" + isFramework() + ")]";
    }
}
