/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package raytracer.tracers;

import raytracer.utilities.*;
import raytracer.world.World;


public class AreaLighting extends Tracer {

	// -------------------------------------------------------------------- default constructor

	public AreaLighting() {
		super();
	}

	// -------------------------------------------------------------------- constructor

	public AreaLighting(World world) {
		super(world);
	}



	// -------------------------------------------------------------------- trace_ray

	public RGBColor trace_ray(Ray ray) {
		ShadeRec sr = world_ptr.hit_bare_bones_objects(ray);
		if (sr.hit_an_object)   {
			sr.r=ray;
			return (sr.material.Shade(sr));
		}
		else
			return (world_ptr.background_color);
	}

	// -------------------------------------------------------------------- trace_ray

	public RGBColor trace_ray(Ray ray, int depth,boolean drawlights) {
		return trace_ray(ray);
	}

}
